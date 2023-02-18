/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.user;

import domain.User;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Iva
 */
public class GetAllUsers extends AbstractGenericOperation{

    private User user;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        users = repository.getAll(param);
        for (User user1 : users) {
            if(user1.getUsername().equals(((User)param).getUsername()) && ((User) param).getPassword().equals(user1.getPassword())){
                this.user = user1;
                break;
            }
        }
    }
    
     public User getUserLogin() throws Exception{
        if (user==null) {
              throw new Exception("Korisnik ne postoji!");
        }
        return user;
    }
    
}
