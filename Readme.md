```bash

1. We are creating spring boot app with java 17
2. In Controller, we pass the request param as page to get the list in desc order.
Means, the page added into the last will display first in the list.

For instance:

    {
        "id": 5,
        "title": "Maninder5",
        "url": "dataguise5.com",
        "createdAt": "2023-03-31T16:10:40.496042Z"
    },
    {
        "id": 4,
        "title": "Maninder4",
        "url": "dataguise4.com",
        "createdAt": "2023-03-31T16:10:40.495632Z"
    }

id 5 will display first.

In the service layer, we have defined the property for pagination:
Pageable pageable = PageRequest.of(pageNo,5, Sort.Direction.DESC,"createdAt");

it means that only 5 records will display on one page. Suppose, we have 10 records and we set the page
size to 5. So, first page we will see only 5 records of latest. If you want to see another records
just pass the page no as 2.

http://localhost:8080/api/bookmarks?page=2

it will display the data present on 2 page.

So, in addition to the data display on pages, we need more information like:
how many pages are avaialable.
how many total elements.
current page
does it has next page or not: return it boolean
does it has previous page or not: return it boolean.
is it firt page: return it true or false.
is it last page: boolean return

3. To achieve this, we created one dto class called "BookMarkDto". 
4. And change the return type for method getBookmarks in service layer with BookMarkDto.

Now output will be like this:

    {
            "id": 2,
            "title": "Maninder2",
            "url": "dataguise2.com",
            "createdAt": "2023-03-31T17:47:01.532387Z"
    },
    {
            "id": 1,
            "title": "Maninder1",
            "url": "dataguise1.com",
            "createdAt": "2023-03-31T17:47:01.510997Z"
    }
    ],
    "totalElements": 10,
    "totalPages": 2,
    "currentPage": 2,  
    "hasNext": false, It does not have next page because total pages are 2.
    "hasPrevious": true, //It has previous page called 1.
    "isFirst": false,  //Is it first page. Ans is no. 
    "isLast": true   //Is this last page. Ans is yes.
}

5. Next step, we will create DTO class, to display the data because meantime we are just displaying
the entity data and that is not a right approach. Sometimes, we don't want to display
all the data. We just need to display only the important data. In that we use dto
concept.

After creating the Mapper, we just pass it in the service layer:
Converting all the parameters to dto using map

Page<BookmarkDto> bookmarkDtoPage= bookmarkRepository.findAll(pageable).map(bookmarkMapper::toDto);

Still here, we are loading all the data first and then mapping it.
For instance: bookmarkRepository.findAll(pageable), we are doing this in above query.
That is not a right approach, because it loads all the data from database first and then
we map it. Instead of this, we can write new method in repository layer with custom data
that will load only required data.

we can do this way:

@Query("select new io.reactivestax.kubernetes.dto.BookmarkDto(b.id, b.title, b.url, b.createdAt) from Bookmark b")
    Page<BookmarkDto> findBookmarks(Pageable pageable);
    

benefit of using dto class over entity:
1. The main benefit of doing so is to avoid exposing sensitive or unnecessary
 information to the outside world.
2. Entity classes typically represent the persistence layer and are used
 to map objects to database tables. They often contain sensitive information, 
such as primary keys, foreign keys, and other fields that should not be
 exposed to the outside world

3. By creating a separate DTO class, you can control exactly what information
 is exposed to the outside world. This can be particularly important when designing
REST APIs,as you want to ensure that only the necessary information is being exposed to clients

4. Another benefit of using DTOs is that they allow you to decouple the internal representation
 of your data from the external representation. This means that you can change the internal
representation of your data (e.g., by adding or removing fields) without affecting the external
representation (i.e., the DTO).

6. Now, we will write the integration test cases for it. I already added comments for explaining
the integration test cases.

7. After writing the test cases, It's the time for dockering the spring boot app to docker.
8. We used to create the DockerFile for dockering the spring boot app and then do docker
build.
9. Instead of that, we can follow the new approach for it:
We already added the maven plugin into the pom file. We can also add
the image name that we want for this boot app into this plugin like
below:

			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<image>
						<name>maninder40407/spring-boot-bookmarks</name>
					</image>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
			
10. Now, we need to run the command for dockering the spring boot app:
./mvnw spring-boot:build-image

It will created the docker images on spring boot app with name mentioned
in plugin: "maninder40407/spring-boot-bookmarks"

11. After that, run command:
docker run -p 8080:8080 maninder40407/spring-boot-bookmarks			
			
12. Our spring boot app is up and working on port 8080.

13. As mentioned above, we created the docker image using maven plugin, the same
thing we can also achieved through the JIB plugin.

we need to add the JIB plugin first:

			<!--JIB plugin configuration-->
			<plugin>
				<groupId>com.google.cloud.tools</groupId>
				<artifactId>jib-maven-plugin</artifactId>
				<version>3.2.1</version>
				<configuration>
					<from>
						<image>openjdk:17-alpine</image>
					</from>
					<to>
						<image>maninder40407/bookmarker-api-jib</image>
						<tags>
							<tag>latest</tag>
							<tag>0.0.1</tag>
						</tags>
					</to>
					<container>
						<ports>
							<port>8080</port>
						</ports>
					</container>
				</configuration>
			</plugin>
			
In this plugin, we mentioned the docker image name with tags along with the port on which it will run.
and we are using base image of "openjdk:17-alpine"

After adding this plugin, run the below mentioned commands:
1. mvn clean package
2. ./mvnw jib:build

The second command will create the image and will store it into the docke hub not on the local.

if you want to create the image on locally, then run this command:
1. mvn clean package
2. ./mvnw jib:dockerBuild

you can also provide the custom name, along with this build for docker image:
./mvnw jib:dockerBuild -Dimage=maninder40407/bookmarker-api-new-custom

Now run the docker image:
docker run -p 8080:8080 maninder40407/bookmarker-api-new-custom

14. CI-CD pipline stuff is done in doc/spring-boot-kubernetes.docx

15. Meantime, we are applying filter on the behalf of pageNo.Now, we are adding one more
parameter called query. On the behalf of it, we can filter out the data that we need.
Suppose, there is list of fruits for example, apple,mango, grapes and we need only
grapes, so in this case, we can sort out the data on the behalf of grapes.

Using query parameter, we can write query like this:

    @Query("""
            select new io.reactivestax.kubernetes.dto.BookmarkDto(b.id, b.title, b.url, b.createdAt)
            from Bookmark b where lower(b.title) like lower(concat('%', :query, '%'))
          """)


and using it, we can pass the query in parameter:
http://localhost:8080/api/bookmarks?query=boot

it will return only those titles, in which it gets boot as a word.

In above way, we have writen the query but same thing we can also achieved through the method naming
conversion provided by the JPA:

Method name should be like. In this case, there is no need of providing the query parameter.
Page<BookmarkDto> findByTitleContainsIgnoreCase(String query, Pageable pageable);


##How to run app?

```shell
$ git clone https://github.com/Maninder416/spring-boot.git
$ cd spring-boot
$ ./run.sh start
$ ./run.sh stop

```
* To start only dependent services

```shell
$ ./run.sh start_infra
$ ./run.sh stop_infra

```






```