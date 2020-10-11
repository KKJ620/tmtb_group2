import axios from "axios";

class GroupApi {
  URL = "/api/groups/";

  groupList() {
    return axios
      .get(this.URL)
      .then((response) => {
        return response.data;
      })
      .catch((error) => console.error(error));
  }

  groupCreate(GroupApiModel) {
    console.log(GroupApiModel);
    return axios
      .post(this.URL, GroupApiModel)
      .then((response) => (response && response.data) || null);
  }

  groupDelete(groupNum) {
    return axios
      .delete(this.URL + `${groupNum}`)
      .then((response) => (response && response.data) || null);
  }

  groupModify(GroupApiModel) {
    return axios
      .put(this.URL, GroupApiModel)
      .then((response) => (response && response.data) || null);
  }
}

export default GroupApi;
