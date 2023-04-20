/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkRequest;

import Business.Employee.Employee;
import java.util.ArrayList;

/**
 *
 * @author emi
 */
public class WorkQueue {
    ArrayList<WorkRequest> workQueue;

    public ArrayList<WorkRequest> getWorkQueue() {
        return workQueue;
    }

    public WorkQueue() {
        this.workQueue = new ArrayList<WorkRequest>();
    }

    public void finishWorkRequest(WorkRequest workReq) {
        workReq.setMessage("Work Request Finished");
        workReq.getOrder().setOrderApproved(true);
        this.workQueue.remove(workReq);
    }
    
    public void rejectWorkRequest(WorkRequest workReq) {
        workReq.setMessage("Work Request Rejected");
        workReq.getOrder().setOrderApproved(false);
        this.workQueue.remove(workReq);
    }

    public void addWorkRequest(WorkRequest workReq) {
        this.workQueue.add(workReq);
    }
    
}
