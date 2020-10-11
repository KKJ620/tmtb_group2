import React from "react";
import { Grid, Header } from "semantic-ui-react";
import "./App.css";
import GroupListContainer from "./container/GroupListContainer";
import GroupEditContainer from "./container/GroupEditContainer";

function App() {
  return (
    <Grid columns={1}>
      <Grid.Row>
        <Grid.Column textAlign="center">
          <Header as="h1">일정관리</Header>
        </Grid.Column>
      </Grid.Row>
      <Grid.Row>
        <Grid.Column>
          <GroupEditContainer />
        </Grid.Column>
      </Grid.Row>
      <Grid.Row>
        <Grid.Column>
          <GroupListContainer />
        </Grid.Column>
      </Grid.Row>
    </Grid>
  );
}

export default App;
