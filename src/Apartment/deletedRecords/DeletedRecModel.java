package Apartment.deletedRecords;

import Apartment.database.DeletedConnection;
import Apartment.models.DeletedRecords;

import java.util.List;

public class DeletedRecModel {
    private DeletedRecView deletedRecView;
    public DeletedRecModel(DeletedRecView deletedRecView){
        this.deletedRecView=deletedRecView;
    }

    public List<DeletedRecords> viewAllRecords() {
        return DeletedConnection.viewAllRecords();
    }

    public DeletedRecords searchRecords(int regno) {
        return DeletedConnection.searchRecords(regno);
    }
}
