import { observable, computed, action } from "mobx";
import GroupApi from "../api/GroupApi";
import GroupApiModel from "../api/model/GroupApiModel";

//1.Mobx Store 클래스 선언
class GroupStore {
  groupApi = new GroupApi();

  //2. 관리해야하는 state 객체 @observable 선언 및 초기화
  @observable
  groups = [];

  @observable
  group = {};

  @observable
  errorMessage = "";

  //3. state 데이터 리턴 - @computed get으로 함수 구현
  @computed
  get getGroup() {
    return this.group ? { ...this.group } : {};
  }

  @computed
  get getGroups() {
    return this.groups ? this.groups.slice() : [];
  }

  @computed
  get getErrorMessage() {
    return this.errorMessage ? this.errorMessage : "FAIL";
  }

  //4. state 데이터 변경 @action 함수 구현
  @action
  selectGroup(groupId) {
    //groups에서 id가 같은 group 객체 변경
    this.group = this.groups.find((element) => element.groupId === groupId);
  }

  @action
  async groupList() {
    this.groups = await this.groupApi.groupList();
    console.log(this.groups);
  }

  @action
  async groupCreate(group) {
    const groupApiModel = new GroupApiModel(
      group.title,
      new Date(group.startDate),
      new Date(group.endDate),
      group.peopleNum,
      group.longTerm
    );
    console.log(group.longTerm);
    const result = this.groupApi.groupCreate(groupApiModel);
    this.groups.push(group);
    if (result == null) this.errorMessage = "CREATE ERROR!";
  }

  @action
  async modifyGroup(groupApiModel) {
    this.groups = this.groups.map((element) =>
      element.groupId === groupApiModel.groupId ? groupApiModel : element
    );
    this.group = {};
    let result = this.groupApi.groupModify(groupApiModel);
    if (result == null)
      this.errorMessage = `${groupApiModel.groupId}UPDATE ERROR!`;
  }

  @action
  async groupDelete(groupId) {
    const result = this.groupApi.groupDelete(groupId);
    this.groups = this.groups.filter((element) => element.groupId !== groupId);
    this.group = {};
    if (result == null) this.errorMessage = `${groupId} DELETE ERROR!`;
  }

  @action
  async selectAll() {
    this.groups = await this.groupApi.groupList();
  }

  @action
  setGroupProp(name, value) {
    this.group = {
      ...this.group,
      [name]: value,
    };
  }
}

//5. 객체 생성해서 export
export default new GroupStore();
