package moe.gensoukyo.easy_command.analyser.utils

import moe.gensoukyo.easy_command.core.ProviderManager.LITERAL_TYPE

class GrammarTree(rootName: String, rootPermission: Int) {

    private val ROOT: GrammarNode = GrammarNode(LITERAL_TYPE, rootName, rootPermission);

    private class GrammarNode(val type: String, val name: String, val permission: Int) {
        private val children = mutableListOf<GrammarNode>()

        fun addChild(node: GrammarNode) {
            children.add(node)
        }
    }
}