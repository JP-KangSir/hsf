
package com.example.sysauth.tree.component;


public interface ITreeComponent {

  /**
   * 获取树最大高度
   *
   * @return
   */
  int getLength();

  /**
   * 获取树节点数量
   *
   * @return
   */
  int count();

  /**
   * 获取叶节点数量
   *
   * @return
   */
  int countLeaves();

}
