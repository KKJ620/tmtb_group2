import React, { Component } from "react";
import { observer, inject } from "mobx-react";
import GroupListView from "../view/GroupListView";

@inject("GroupStore")
@observer
class GroupListContainer extends Component {
  componentDidMount() {
    const { GroupStore } = this.props;

    GroupStore.groupList();
  }

  onSelectGroup = (groupId) => {
    console.log(groupId);
    this.props.GroupStore.selectGroup(groupId);
  };

  render() {
    const groups = this.props.GroupStore.getGroups;
    console.log(groups);
    return <GroupListView groups={groups} onSelectGroup={this.onSelectGroup} />;
  }
}

export default GroupListContainer;
