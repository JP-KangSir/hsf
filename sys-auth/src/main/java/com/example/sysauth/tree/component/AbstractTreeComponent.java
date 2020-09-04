
package com.example.sysauth.tree.component;

import com.example.sysauth.tree.enums.TreeComponentType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class AbstractTreeComponent implements ITreeComponent {

  @ApiModelProperty(value = "子节点")
  protected List<TreeComponent> children = new ArrayList<>();

  @Override
  public int getLength() {
    int length = 0;
    int temp = 0;
    for (TreeComponent node : children) {
      temp = (node.getType() == TreeComponentType.LEAF ? 1 : node.getLength());
      length = length < temp ? temp : length;
    }
    return length + 1;
  }

  @Override
  public int count() {
    int count = 0;
    for (TreeComponent node : children) {
      count += (node.getType() == TreeComponentType.LEAF ? 1 : node.count());
    }
    return count + 1;
  }

  @Override
  public int countLeaves() {
    int count = 0;
    for (TreeComponent node : children) {
      count += (node.getType() == TreeComponentType.LEAF ? 1 : node.countLeaves());
    }
    return count;
  }
}
