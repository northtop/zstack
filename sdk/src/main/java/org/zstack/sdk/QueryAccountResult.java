package org.zstack.sdk;

public class QueryAccountResult {
    public java.util.List<AccountInventory> inventories;
    public void setInventories(java.util.List<AccountInventory> inventories) {
        this.inventories = inventories;
    }
    public java.util.List<AccountInventory> getInventories() {
        return this.inventories;
    }

    public java.lang.Long total;
    public void setTotal(java.lang.Long total) {
        this.total = total;
    }
    public java.lang.Long getTotal() {
        return this.total;
    }

}
