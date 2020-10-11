import React, { Component } from "react";
import { observer, inject } from "mobx-react";
import GroupEditFormView from "../view/GroupEditFormView";

@inject("GroupStore")
@observer
class GroupEditContainer extends Component {
  onSetGroup = (name, value) => {
    this.props.GroupStore.setGroupProp(name, value);
  };

  onAddGroup = () => {
    //GroupStore의 addGroup(group) 호출
    let group = this.props.GroupStore.group;
    this.props.GroupStore.groupCreate(group);
  };

  onRemoveGroup = () => {
    let group = this.props.GroupStore.group;
    this.props.GroupStore.groupDelete(group.groupId);
  };

  onModifyGroup = () => {
    let group = this.props.GroupStore.group;
    this.props.GroupStore.modifyGroup(group);
  };

  render() {
    const { group } = this.props.GroupStore;
    return (
      <GroupEditFormView
        group={group}
        onSetGroup={this.onSetGroup}
        onAddGroup={this.onAddGroup}
        onRemoveGroup={this.onRemoveGroup}
        onModifyGroup={this.onModifyGroup}
      />
    );
  }
}

export default GroupEditContainer;
