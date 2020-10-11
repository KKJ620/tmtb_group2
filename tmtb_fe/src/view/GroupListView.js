import React, { Component } from "react";
import { Table } from "semantic-ui-react";
import moment from "moment";

class GroupListView extends Component {
  render() {
    const { groups, onSelectGroup } = this.props;
    console.log(groups);
    return (
      <Table celled>
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell>방제</Table.HeaderCell>
            {/* <Table.HeaderCell>태그</Table.HeaderCell> */}
            <Table.HeaderCell>멤버 수</Table.HeaderCell>
            <Table.HeaderCell>시작 날</Table.HeaderCell>
            <Table.HeaderCell>끝나는 날</Table.HeaderCell>
            <Table.HeaderCell>장기 여부</Table.HeaderCell>
          </Table.Row>
        </Table.Header>

        <Table.Body>
          {Array.isArray(groups) && groups.length ? (
            groups.map((group) => {
              return (
                <Table.Row
                  key={group.groupId}
                  onClick={() => onSelectGroup(group.groupId)}
                >
                  <Table.Cell>{group.title}</Table.Cell>
                  {/* <Table.Cell>{group.tag}</Table.Cell> */}
                  <Table.Cell>{group.peopleNum}</Table.Cell>
                  <Table.Cell>
                    {moment(group.startDate).format("YYYY-MM-DD HH:mm")}
                  </Table.Cell>
                  <Table.Cell>
                    {moment(group.endDate).format("YYYY-MM-DD HH:mm")}
                  </Table.Cell>
                  <Table.Cell>{group.longTerm ? "o" : ""}</Table.Cell>
                </Table.Row>
              );
            })
          ) : (
            <Table.Row>
              <Table.Cell>자유참여방</Table.Cell>
            </Table.Row>
          )}
        </Table.Body>
      </Table>
    );
  }
}
export default GroupListView;
