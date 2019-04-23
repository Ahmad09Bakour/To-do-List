package org.fasttrackit.service;

import org.fasttrackit.domain.ToDoItem;
import org.fasttrackit.persistence.ToDoItemRepository;
import org.fasttrackit.transfer.MarkItemDoneRequest;
import org.fasttrackit.transfer.SaveToDoItemRequest;
import sun.nio.cs.ext.MacArabic;

import java.sql.SQLException;
import java.util.List;

public class ToDoItemService {

    private ToDoItemRepository toDoItemRepository = new ToDoItemRepository();
    public void createToDoItem(SaveToDoItemRequest request) throws SQLException {
        System.out.println("Creating To Do item: " + request);
        toDoItemRepository.createToDoItem(request);


    }

    public List<ToDoItem> getToDoItems() throws SQLException {
        System.out.println("Retrieving to do items.");
        return toDoItemRepository.getToDoItem();
    }

    public void markToDoItemDone(long id, MarkItemDoneRequest request) throws SQLException {
        System.out.println("Updating to do item" + id + " with " + request);

        toDoItemRepository.markToDoItemDone(id, request.isDone());
    }

    public void deleteToDoItem(long id) throws SQLException {
        System.out.println("Deleting the item " + id);
        toDoItemRepository.deleteItem(id);
    }
}
