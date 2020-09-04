
package com.example.sysauth.tree.builder;

public interface IComponentBuilder<T> {

  /**
   * 获取编号
   *
   * @param t
   * @return
   */
  String getId(T t);

  /**
   * 获取父节点编号
   *
   * @param t
   * @return
   */
  String getPid(T t);

  /**
   * 获取节点名称
   *
   * @param t
   * @return
   */
  default String getName(T t) {
    return "";
  }

}
