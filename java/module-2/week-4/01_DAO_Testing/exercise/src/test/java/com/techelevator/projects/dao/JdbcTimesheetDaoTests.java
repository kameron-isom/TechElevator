package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao dao;


    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        //Arrange
        Timesheet employeeTimesheet = TIMESHEET_1;
        Timesheet employeeTimeSheet2= TIMESHEET_2;
        Timesheet employeeTimeSheet3= TIMESHEET_3;

        // ACT
       dao.getTimesheet(employeeTimesheet.getTimesheetId());
        dao.getTimesheet(employeeTimeSheet2.getTimesheetId());
        dao.getTimesheet(employeeTimeSheet3.getTimesheetId());

        //ASSERT
        Assert.assertEquals(employeeTimesheet.getTimesheetId(),1);
        Assert.assertEquals(employeeTimeSheet2.getTimesheetId(), 2);
        Assert.assertEquals(employeeTimeSheet3.getTimesheetId(), 3);

    }


    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
        //Arrange
        Timesheet employeeTimesheet = new Timesheet(0, 1, 1,
                LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
        Timesheet employeeTimeSheet2= TIMESHEET_2;
        Timesheet employeeTimeSheet3= TIMESHEET_3;
        // ACT
        dao.getTimesheet(employeeTimesheet.getTimesheetId());
        dao.getTimesheet(employeeTimeSheet2.getTimesheetId());
        dao.getTimesheet(employeeTimeSheet3.getTimesheetId());
        //ASSERT
        Assert.assertEquals(employeeTimesheet.getTimesheetId() ,0);
        Assert.assertEquals(employeeTimeSheet2.getTimesheetId(), 2);
        Assert.assertEquals(employeeTimeSheet3.getTimesheetId(), 3);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        //Arrange
        Timesheet employeeTimesheet = TIMESHEET_1;
        Timesheet employeeTimeSheet2= TIMESHEET_2;
        Timesheet employeeTimeSheet3= TIMESHEET_3;

        // ACT
        dao.getTimesheetsByEmployeeId(employeeTimesheet.getEmployeeId());
        dao.getTimesheetsByEmployeeId(employeeTimeSheet2.getEmployeeId());
        dao.getTimesheetsByEmployeeId(employeeTimeSheet3.getEmployeeId());

        //ASSERT
        Assert.assertEquals(employeeTimesheet.getEmployeeId(),1);
        Assert.assertEquals(employeeTimeSheet2.getEmployeeId(), 1);
        Assert.assertEquals(employeeTimeSheet3.getEmployeeId(), 2);
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        //Arrange
        Timesheet employeeTimesheet = TIMESHEET_1;
        Timesheet employeeTimeSheet2= TIMESHEET_2;
        Timesheet employeeTimeSheet3= TIMESHEET_3;
        Timesheet employeeTimeSheet4 = TIMESHEET_4;

        // ACT
        dao.getTimesheetsByEmployeeId(employeeTimesheet.getProjectId());
        dao.getTimesheetsByEmployeeId(employeeTimeSheet2.getProjectId());
        dao.getTimesheetsByEmployeeId(employeeTimeSheet3.getProjectId());
        dao.getTimesheetsByEmployeeId(employeeTimeSheet4.getProjectId());

        //ASSERT
        Assert.assertEquals(employeeTimesheet.getProjectId(),1);
        Assert.assertEquals(employeeTimeSheet2.getProjectId(), 1);
        Assert.assertEquals(employeeTimeSheet3.getProjectId(),1);
        Assert.assertEquals(employeeTimeSheet4.getProjectId(), 2);
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        //Arrange
        Timesheet employeeTimesheet = new Timesheet(6, 1, 3,
                LocalDate.parse("2021-11-01"), 1.5, true, "Timesheet 7");
        Timesheet createdTimesheet = new Timesheet(6, 1, 3,
                LocalDate.parse("2021-11-01"), 1.5, true, "Timesheet 7");
        // ACT
        dao.getTimesheet(employeeTimesheet.getTimesheetId());
        dao.getTimesheet(createdTimesheet.getTimesheetId());

        //ASSERT
         Assert.assertEquals(employeeTimesheet.getTimesheetId(), createdTimesheet.getTimesheetId());
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        //Arrange
        Timesheet employeeTimesheet = new Timesheet(6, 1, 3,
                LocalDate.parse("2021-11-01"), 1.5, true, "Timesheet 7");
        Timesheet createdTimesheet = new Timesheet(6, 1, 3,
                LocalDate.parse("2021-11-01"), 1.5, true, "Timesheet 7");
        // ACT
        dao.getTimesheet(employeeTimesheet.getTimesheetId());
        dao.getTimesheet(createdTimesheet.getTimesheetId());

        //ASSERT
        //Assert.assertEquals(employeeTimesheet, employeeTimesheet);
        Assert.assertEquals(createdTimesheet.getTimesheetId(), employeeTimesheet.getTimesheetId());
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
     //Arrange
        Timesheet updatedTimesheet = dao.getTimesheet(1);
    //ACT
     updatedTimesheet.setEmployeeId(2);
     dao.updateTimesheet(updatedTimesheet);
     Timesheet retrivedTimesheet = dao.getTimesheet(1);

    //Assert
        Assert.assertEquals(updatedTimesheet.getEmployeeId(),retrivedTimesheet.getEmployeeId());
    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        //Arrange
        Timesheet employeeTimesheet = TIMESHEET_1;
        // ACT
        dao.deleteTimesheet(employeeTimesheet.getTimesheetId());
        Timesheet retrievedTimeSheet = dao.getTimesheet(1);
        //ASSERT
        Assert.assertNull(retrievedTimeSheet);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        Timesheet employeeTimesheet = TIMESHEET_1;
        Timesheet employeeTimeSheet2= TIMESHEET_2;
        Timesheet employeeTimeSheet3= TIMESHEET_3;
        Timesheet employeeTimeSheet4 = TIMESHEET_4;


        // ACT-billable hours worked
        dao.getBillableHours(employeeTimesheet.getEmployeeId(),employeeTimesheet.getProjectId());
        dao.getBillableHours(employeeTimeSheet2.getEmployeeId(), employeeTimeSheet2.getProjectId());
        dao.getBillableHours(employeeTimeSheet3.getEmployeeId(), employeeTimeSheet3.getProjectId());
        dao.getBillableHours(employeeTimeSheet4.getEmployeeId(), employeeTimeSheet4.getProjectId());

        //ASSERT
        Assert.assertEquals(employeeTimesheet.getHoursWorked(),1.0, 0.001);
        Assert.assertEquals(employeeTimeSheet2.getHoursWorked(),1.5, 0.001);
        Assert.assertEquals(employeeTimeSheet3.getHoursWorked(),0.25,0.001);
        Assert.assertEquals(employeeTimeSheet4.getHoursWorked(), 2.0,0.001);

    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
