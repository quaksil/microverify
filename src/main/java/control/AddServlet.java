package control;

import dbHelpers.AddQuery;
import model.Department;
import model.Faculty;
import model.Major;
import model.Students;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AddServlet", value = "/addStudent")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        Students.gender gender = Students.gender.valueOf(request.getParameter("gender"));
        Date bday = Date.valueOf(request.getParameter("bday"));
        String firstfather = request.getParameter("firstfather");
        String firstmaiden = request.getParameter("firstmaiden");
        String lastmaiden = request.getParameter("lastmaiden");
        String facultyName = request.getParameter("faculty");
        String departmentName = request.getParameter("department");
        String course = request.getParameter("course");
        String level = request.getParameter("level");
        String majorName = request.getParameter("major");
        int lastyear = Integer.parseInt(request.getParameter("lastyear"));

        Students student = new Students();
        Faculty faculty = new Faculty();
        Department department = new Department();
        Major major = new Major();

        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setGender(gender);
        student.setBday(bday);
        student.setFirstfather(firstfather);
        student.setFirstmaiden(firstmaiden);
        student.setLastmaiden(lastmaiden);

        faculty.setName(facultyName);
        faculty.setUniversity("Constantine 2 University");
        student.setFaculty(faculty);

        department.setName(departmentName);
        department.setFaculty(faculty.getName());
        student.setDepartment(department);

        student.setCourse(course);
        student.setLevel(level);

        major.setName(majorName);
        major.setDepartment(department.getName());
        student.setMajor(major);

        student.setLastyear(lastyear);

        AddQuery aq = new AddQuery();

        aq.doAdd(student);

        String url = "/read";

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);


    }
}
