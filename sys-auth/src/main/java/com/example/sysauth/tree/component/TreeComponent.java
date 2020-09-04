
package com.example.sysauth.tree.component;

import com.example.sysauth.tree.enums.TreeComponentType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "pid", "length", "type", "content", "nodes"})
public class TreeComponent extends AbstractTreeComponent {

  @ApiModelProperty(value = "唯一标识")
  private String id;
  @ApiModelProperty(value = "父id")
  private String pid;
  @ApiModelProperty(value = "节点名称")
  private String name;
  @ApiModelProperty(value = "节点内容")
  private Object content;
  @ApiModelProperty(value = "节点类型")
  private TreeComponentType type;

  public void add(TreeComponent node) {
    if (this.type == TreeComponentType.LEAF) {
      this.type = TreeComponentType.BRANCH;
    }
    children.add(node);
  }

}
