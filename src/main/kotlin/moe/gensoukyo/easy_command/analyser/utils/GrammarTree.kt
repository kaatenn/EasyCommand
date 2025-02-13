package moe.gensoukyo.easy_command.analyser.utils

import moe.gensoukyo.easy_command.core.ProviderManager.LITERAL_TYPE

class GrammarTree(rootName: String, rootPermission: Int?, args: String?) {

    private val ROOT: GrammarNode = GrammarNode(LITERAL_TYPE, rootName, rootPermission, args)

    class GrammarNode(private val type: String, private val name: String, private val permission: Int?, private val args: String?) {
        private val children = mutableListOf<GrammarNode>()

        fun addChild(node: GrammarNode) {
            children.add(node)
        }

        companion object {

            private val snakeCaseRegex = Regex("^_{0,2}[a-z][a-z0-9_]*$")

            fun fromFormattedString(str: String): GrammarNode {
                val parts = str.split(":")
                if (parts.size < 2)
                    throw IllegalArgumentException("Invalid argument: node $str. Every node should have at least two parts that means type and name")

                val type = parts[0]
                val name = parts[1]

                if (!type.matches(snakeCaseRegex))
                    throw IllegalArgumentException("Invalid argument: type $type. Type should be named in snake case")
                if (!name.matches(snakeCaseRegex))
                    throw IllegalArgumentException("Invalid argument: name $name. Name should be named in snake case")

                val permission = if (parts.size >= 3 && parts[2].isNotBlank()) {
                    parts[2].toIntOrNull()
                } else null

                val args = if (parts.size >= 4 && parts[4].isNotBlank()) {
                    parts[4]
                } else null

                return GrammarNode(type, name, permission, args)
            }
        }
    }
}