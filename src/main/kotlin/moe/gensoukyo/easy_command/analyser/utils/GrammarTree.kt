package moe.gensoukyo.easy_command.analyser.utils

import moe.gensoukyo.easy_command.core.ProviderManager.LITERAL_TYPE

class GrammarTree(
    rootName: String,
    rootPermission: Int?,
    args: String?) {

    private val ROOT: GrammarNode = GrammarNode(LITERAL_TYPE, rootName, rootPermission, args)

    class GrammarNode(
        private val type: String,
        private val name: String,
        private val permission: Int?,
        private val args: String?) {

        private val children = mutableListOf<GrammarNode>()

        fun addChild(node: GrammarNode) = children.add(node)

        companion object {

            private val snakeCaseRegex = Regex("^_{0,2}[a-z][a-z0-9_]*$")


            /**
             * 从格式化字符串创建 GrammarNode 对象
             * 字符串格式应为：type:name[:permission[:args]]
             * @throws IllegalArgumentException 当格式不正确时抛出异常
             */
            fun fromFormattedString(str: String): GrammarNode {
                val parts = str.split(":")
                require(parts.size >= 2) {
                    "Invalid argument: node '$str'. Every node should have at least two parts: type and name"
                }

                val type = parts[0]
                val name = parts[1]
                require(type.matches(snakeCaseRegex)) { "Invalid argument: type '$type'. Type should be named in snake case" }
                require(name.matches(snakeCaseRegex)) { "Invalid argument: name '$name'. Name should be named in snake case" }

                val permission = parts.getOrNull(2)?.takeIf { it.isNotBlank() }?.toIntOrNull()
                val args = parts.getOrNull(3)?.takeIf { it.isNotBlank() }

                return GrammarNode(type, name, permission, args)
            }
        }
    }
}