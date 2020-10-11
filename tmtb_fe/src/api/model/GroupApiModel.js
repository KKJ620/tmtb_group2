class GroupApiModel {
  groupId = 0;
  title = "";
  startDate = "";
  endDate = "";
  peopleNum = 0;
  longTerm = true;

  constructor(title, startDate, endDate, peopleNum, longTerm) {
    this.title = title;
    this.startDate = startDate;
    this.endDate = endDate;
    this.peopleNum = peopleNum;
    this.longTerm = longTerm;
  }
  setGroupId(groupId) {
    this.groupId = groupId;
  }
}

export default GroupApiModel;
