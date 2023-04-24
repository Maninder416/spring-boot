### Spring boot app with security


### Topics covered in this spring boot app:
```shell
1. Docker mysql running local spring boot app.
2. In this app, we are only creating one application.yml file and 
executing multiple profiles in the same yml file like dev and test.
If no profile is selected then default will call and if you mention
dev or test and then accordling it will pick the values.
3. To test it, create a endpoint which print the value accordingly.

@GetMapping("/test")
public String test(){
    return statement;
} 
So when we have an option to do everythig within in yml file why need of creating
multiple files?


Yes,it's possible to define all the configuration for an application
in a single YAML file, but it may not be the most efficient or
scalable approach.Using multiple YAML files can help to keep the
configuration organized and modular. For example, you might have a
separate YAML file for each environment (development, staging, production),
or for different components of your application (database, caching, security).
This can make it easier to manage and update the configuration for specific
parts of your application without affecting others.Additionally, using
separate YAML files can make it easier to share and collaborate on 
configuration with other team members. You can commit and version control
each file separately, and team members can update or modify specific files
without having to work with a single large, complex YAML file.

Overall, the decision to use multiple YAML files or a single file will
depend on the complexity and scale of your application, as well as
your personal preferences and development practices.
```

### How to run spring boot app:
```shell
1. Need to run docker-compose file first as we are using docker mysql
2. Run the spring boot app.
```

