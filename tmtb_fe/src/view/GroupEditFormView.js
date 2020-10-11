import React from "react";
import { Form, Button, Radio } from "semantic-ui-react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

const GroupEditFormView = (props) => {
  const { group, onSetGroup, onAddGroup, onRemoveGroup, onModifyGroup } = props;
  return (
    <Form>
      <Form.Group widths="equal">
        <Form.Input
          fluid
          label="방제"
          placeholder="방제"
          value={group && group.title ? group.title : ""}
          onChange={(e) => onSetGroup("title", e.target.value)}
        />
        <Form.Input
          fluid
          label="멤버 수"
          placeholder="멤버 수"
          value={group && group.peopleNum ? group.peopleNum : ""}
          onChange={(e) => onSetGroup("peopleNum", e.target.value)}
        />
        <Form.Field>
          <label>시작 날</label>
          <DatePicker
            showTimeSelect
            selected={
              group && group.startDate ? new Date(group.startDate) : null
            }
            dateFormat="yyyy-MM-dd-hh:mm"
            timeFormat="hh:mm"
            timeIntervals={15}
            onChange={(date) => onSetGroup("startDate", date.valueOf())}
          />
        </Form.Field>
        <Form.Field>
          <label>끝나는 날</label>
          <DatePicker
            showTimeSelect
            selected={group && group.endDate ? new Date(group.endDate) : null}
            dateFormat="yyyy-MM-dd-hh:mm"
            timeFormat="hh:mm"
            timeIntervals={15}
            onChange={(date) => onSetGroup("endDate", date.valueOf())}
          />
        </Form.Field>
        <Form.Field>
          <label>장기 여부</label>
          <Radio
            toggle
            onChange={(event, data) => onSetGroup("longTerm", data.checked)}
          />
        </Form.Field>
      </Form.Group>
      <Button primary onClick={onAddGroup}>
        Add
      </Button>
      <Button primary onClick={onRemoveGroup}>
        Remove
      </Button>
      <Button primary onClick={onModifyGroup}>
        Modify
      </Button>
    </Form>
  );
};

export default GroupEditFormView;
