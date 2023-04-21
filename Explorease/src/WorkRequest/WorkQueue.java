/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkRequest;

import Business.Customer.Customer;
import Business.Employee.Employee;
import Business.Organization.Organization;
import Order.Order;
import UserAccount.UserAccount;
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
    
    //to add the work request to org's work queue
    public void addWorkRequest(WorkRequest workReq) {
        this.workQueue.add(workReq);
    }
    
    //this is for customer to initiate the first work request for an order
    public WorkRequest newWorkRequest(Order o,Customer c, UserAccount s, Organization recieverOrg){
        WorkRequest wr = new WorkRequest(o,c,s,recieverOrg);
        this.workQueue.add(wr);
        return wr;
    }
    
}
