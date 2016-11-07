package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 11/6/2016.
 */
public class EmployeeBag {

    private List<Employee> EmployeeBag = new ArrayList<Employee>();

    public void addEmployee(Employee employee) {
        EmployeeBag.add(employee);
    }

    public void removeEmployee(Employee employee) {
        EmployeeBag.remove(employee);
    }

    public Employee findEmployee(Employee employee) {
        for(int i = 0;i < EmployeeBag.size();i++){
            if (EmployeeBag.get(i) == employee) {
                return EmployeeBag.get(i);
            }
        }
        return null;
    }
}


