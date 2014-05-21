/**
 * @see http://algs4.cs.princeton.edu/42directed/DepthFirstOrder.java.html
 */
package org.gs.digraph

import scala.collection.mutable.Queue

/**
 * @author Gary Struthers
 *
 */
class DepthFirstOrder(g: Digraph) extends BaseDepthFirstOrder(g.v){

  def dfs(v: Int): Unit = {
    marked(v) = true
    preCounter += 1
    _pre(v) = preCounter
    preOrder.enqueue(v)
    for {
      w <- g.adj(v)
      if (!marked(w))
    } dfs(w)
    postOrder.enqueue(v)
    postCounter += 1
    _post(v) = postCounter
  }
}