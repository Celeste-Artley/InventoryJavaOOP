#The objective of this Project is to build a desktop application that allows a user to capture ToDo items and categorize them into groups.#

##Objectives:##

- ToDo List
- User Management
- Interface

##Criteria:##

 ###Criteria for ToDo Success###
1. Each ToDo Item ("ToDo") can be stand-alone (Uncategorized) or part of a Category of Item's (Categorized)
2. Each ToDo can have zero or more Tags associated with it
 - Tags are independent of Categories and can be used by users to group visually similar ToDo
3. Each ToDo must have only one Recipient and Creator
4. Each ToDo must have a Created Date, Last Updated Date, Start Date, Due Date and Completion Date - Due Date can be a specific date - Due Date can be a number of days from Start Date, options could include Business Days or Calendar Week Days
5. Each ToDo must have a Short and Long description
6. Each ToDo must have a Completed Checkbox 
7. Each ToDo must have the ability capture a List of Updates

 ###Criteria for User Management###
- A User can be assigned one or more Roles within the Application
1. Suggested Roles: Read, Edit, Update, Manage, and/or Administer
2. Read - User will only be able to View various ToDo List/Tags
3. Edit - User will be able to Read and Create/Modify ToDo List and Items but not Update an individual ToDo Item
4. Update - User will be able to Read and Update individual ToDo Items; They will NOT be able to update the details of the ToDo Item
5. Manage - User will be able to Read, Edit, and Update but will NOT be able to manage User's
6. Administer - User will be able to Read, Edit, Update, and Manage; in addition, they will be able to Add, Edit, and Remove Users from the Application; This will generally also  include changing User Password and User contact
- A User can self-register or be pre-registered by an Administrator
- Once a User has an ID to login, the ID cannot be changed
- User can change contact information and reset their password
- 
###Criteria for Interface###
1. Must have a text-base navigation menubar
2. Must have a image-based navigation menubar with common actions; can be Role based but not necessary
3. Body must be split into two sections
- Left-side: an expandable list of Categories
- Right-side: shows the ToDo items of the Category
4. The Right-Side of the Body, must be a GridView of the ToDo items
5. The GridView rows must be clickable (Single or Double; suggest Double) to show a DetailsView of the Item clicked
6. DetailsView must provide the ability appropriate with the User's Role
7. Must have appropriate access to Role-based features
8. Role-based features must ONLY be visible to user's within that Role
