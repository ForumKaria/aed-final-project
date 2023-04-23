/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Product;

/**
 *
 * @author forumkaria
 */
public
        class InsuranceProduct extends Product {

    String insurancePlan;
    static int ctr =1;
    // Constructor
    public InsuranceProduct(String insurancePlan, int price) {

        super("INSURANCE_PLAN_"+String.valueOf(ctr),price);
        ctr+=1;
        this.insurancePlan= insurancePlan;
    }

    // Override abstract method to get product details
    @Override
    public InsuranceProduct getProductDetails() {
        return this;
    }

    public String getInsurancePlan() {
        return insurancePlan;
    }

    public void setInsurancePlan(String insurancePlan) {
        this.insurancePlan = insurancePlan;
    }
}





