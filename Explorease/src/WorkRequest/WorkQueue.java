/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkRequest;

import Business.Customer.Customer;
import Business.Employee.Employee;
import Business.Organization.Organization;
import Business.Platform;
import Business.Product.Product;
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
        workReq.setStatus("Work Request Finished");
        workReq.getOrder().setOrderApproved(true);
//        this.workQueue.remove(workReq); //let the record stay, in case the agent needs to set status msg after approve/rej
    }

    public void rejectWorkRequest(WorkRequest workReq) {
        workReq.setStatus("Work Request Rejected");
        workReq.getOrder().setOrderApproved(false);
//        this.workQueue.remove(workReq);
    }

    public void sendDetailsToCustomer(TripPlanningWorkRequest workReq) {
        Customer c = workReq.getCustomer();
        c.addToPlannedTrips(workReq);

        workReq.setStatus("Details sent to customer"); 
//        workReq.getOrder().setOrderApproved(true); //not finished yet, may need to book
//        this.workQueue.remove(workReq);
    }

    //to add the work request to org's work queue
    public void addWorkRequest(WorkRequest workReq) {
        this.workQueue.add(workReq);
    }

    //use customer's order to create work request
    public WorkRequest newWorkRequest(Order o,Customer c, UserAccount sender,Platform platform){
        WorkRequest wr = new WorkRequest(o,c,sender,platform);
        this.workQueue.add(wr);
        return wr;
    }

    public AirTicketWorkRequest newAirTicketWorkRequest(Order o,Customer c, UserAccount sender,Platform platform){
        AirTicketWorkRequest wr = new AirTicketWorkRequest(o,c,sender,platform);
        this.workQueue.add(wr);
        return wr;
    }

    public FoodServiceWorkRequest newFoodServiceWorkRequest(Order o,Customer c, UserAccount sender,Platform platform){
       FoodServiceWorkRequest wr = new FoodServiceWorkRequest(o,c,sender,platform);
        this.workQueue.add(wr);
        return wr;
    }

    public HotelBookingWorkRequest newHotelBookingWorkRequest(Order o,Customer c, UserAccount sender,Platform platform){
       HotelBookingWorkRequest wr = new HotelBookingWorkRequest(o,c,sender,platform);
        this.workQueue.add(wr);
        return wr;
    }

    public TripPlanningWorkRequest newTripPlanningWorkRequest(Order o,Customer c, UserAccount sender,Platform platform){
       TripPlanningWorkRequest wr = new TripPlanningWorkRequest(o,c,sender,platform);
        this.workQueue.add(wr);
        return wr;
    }

    public InsuranceWorkRequest newInsuranceWorkRequest(Order o,Customer c, UserAccount sender,Platform platform){
       InsuranceWorkRequest wr = new InsuranceWorkRequest(o,c,sender,platform);
        this.workQueue.add(wr);
        return wr;
    }

    public AttractionBookingWorkRequest newAttractionBookingWorkRequest(Order o,Customer c, UserAccount sender,Platform platform){
       AttractionBookingWorkRequest wr = new AttractionBookingWorkRequest(o,c,sender,platform);
        this.workQueue.add(wr);
        return wr;
    }



}
