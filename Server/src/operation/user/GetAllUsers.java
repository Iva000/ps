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
            //System.out.println(user1);
            if(user1.getUsername().equals(((User)param).getUsername()) && ((User) param).getPassword().equals(user1.getPassword())){
                //System.out.println("Pronasao ga je! User Postoji");
                this.user = user1;
                //flag = true;
                break;
            }
        }
    }
    
     public User getUserLogin() throws Exception{
        System.out.println("LOGIN");
        if (user==null) {
              throw new Exception("User does not exsist!");
        }
        return user;
    }
    
}
