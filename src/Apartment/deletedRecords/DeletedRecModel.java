package Apartment.deletedRecords;


import Apartment.dbConnection.DeletedConnection;
import Apartment.models.DeletedRecords;

import java.util.List;

public class DeletedRecModel {
    private DeletedRecView deletedRecView;
    private static DeletedConnection delconnect=new DeletedConnection();
    public DeletedRecModel(DeletedRecView deletedRecView){
        this.deletedRecView=deletedRecView;
    }

    public List<DeletedRecords> viewAllRecords() {
        return delconnect.viewAllRecords();
    }

    public DeletedRecords searchRecords(int regno) {
        return delconnect.searchRecords(regno);
    }
}
