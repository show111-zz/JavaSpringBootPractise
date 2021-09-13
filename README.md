# Coding Assignment - Backend

## Introduce
<p>The project is a Maven archetype for Spring Boot web application. The database uses H2. <br>
It allows user login and create/update/delete their profile information.</p>


## Run the project
#### Run project difference between first time and other times
> First time to Login need the first step. 
1. Find the UserLoginDAOImpl.java file(com/amdocs/assignment/dao/UserLoginDAOImpl.java). <br>
Uncomment the line 25 ` userLoginRepository.save(new User(name, password));` 

2. Find and open the AssignmentApplication.java file. Right-click and run 'AssignmentApplication'.

3. Open browser and input http://localhost:9090/assignment.

4. Enter the "admin" as userName and "root" as password.


## Test on the browser
http://localhost:9090/assignment


## Demo pages
1. User login pages:
- !(/WEB-INF/images/login1.png "Login1")
- !(/WEB-INF/images/login2.png "Login2")

2. Add profile pages:
- !(/WEB-INF/images/add_profile1.png "AddProfile1")
- !(/WEB-INF/images/add_profile2.png "AddProfile2")

3. Edit profile pages:
- !(/WEB-INF/images/edit_profile1.png "EditProfile1")
- !(/WEB-INF/images/edit_profile2.png "EditProfile2")
- !(/WEB-INF/images/edit_profile3.png "EditProfile3")

4. Delete profile pages:
- !(/WEB-INF/images/delete_profile1.png "DeleteProfile1")
- !(/WEB-INF/images/delete_profile2.png "DeleteProfile2")
