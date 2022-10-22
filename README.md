
<a name="readme-top"></a>


<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a>
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

<br />
<h1 align="center">Travel Management Service</h1>

  
  

  <p align="center">
    API service built using Java to accept, reject and manage travel permissions using JWT Authentication Mechanism. 
    <br />
    <br/>
    <a href="http://epass-service.herokuapp.com/api/posts/all">View Demo</a>
    <!-- · <a href="https://bqwerr.github.io">Explore the docs</a> -->
    ·
    <a href="https://github.com/bqwerr">View More »</a>
  </p>
</div>

<br />

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <!-- <li><a href="#contributing">Contributing</a></li> -->
    <!-- <li><a href="#license">License</a></li> -->
    <li><a href="#contact">Contact</a></li>
    <!-- <li><a href="#acknowledgments">Acknowledgments</a></li> -->
  </ol>
</details>


<br />

<!-- ABOUT THE PROJECT -->
## About The Project
<br />

[![Screenshots](images/gif.gif)](http://epass-portal.herokuapp.com/)

This repository has a Java backend API built using Spring Boot Framework for the frontend application - <a href="https://github.com/bqwerr/react-epass-portal">Travel Management Portal</a> to accept, reject and manage the travel permissions raised by application users. Authentication and Authorization is secured by <a href="https://jwt.io/">Json Web Tokens</a>

<br />



### Built With

[![My Skills](https://skillicons.dev/icons?i=java,spring,postgres,heroku&perline=4)](https://skillicons.dev)


<br />

<!-- GETTING STARTED -->
## Getting Started

To get a local copy of this backend application up and running follow these example steps.

### Prerequisites

* Sprint Tool Suite, Java & PostgreSQL have to be installed in the local system.

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/bqwerr/spring-epass-service.git
   ```
2. Open the project in Spring Tool Suite
3. Convert to Maven & Build Project
4. Change database properties in ```application.properties``` file
4. Run the application

- Now your backend API will be running on port specified in ```application.properties``` file.
- If no port has specified, by default it should run on port ```8080```.
- To get the frontend application, please refer this <a href="https://github.com/bqwerr/react-epass-portal">repository</a>.

<br />



<!-- USAGE EXAMPLES -->
## Usage

_For usage of endpoints, please refer to the [Documentation](https://htmlpreview.github.io/?https://github.com/bqwerr/spring-epass-service/blob/master/documentation.htm)_

- After logging in using valid credentials, Authentication Token & Refresh Token are generated, which can be used to access the Endpoints.
 
![AuthenticationToken](/images/6.png)

<br />



<!-- ROADMAP -->
## Roadmap

- [x] Create Java Backend API endpoints for Authentication & Authorization, Managing User Permissions & Admin Posts.
- [x] Secure API endpoints using JWT Authentication
    - [x] Refresh Token functionality was enabled to extend user session
- [x] Create API Docuementation
- [x] Create a frontend & consume the API
- [ ] ResponseEntity Manipulations with Response Status
<br />

<!-- See the [open issues](https://github.com/github_username/repo_name/issues) for a full list of proposed features (and known issues). -->




<!-- CONTRIBUTING -->
<!-- ## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<br /> -->



<!-- CONTACT -->

## Contact

[GMail][gmail] \
[LinkedIn][linkedin] \
[GitHub][github] \
[Website][website] 




<!-- ACKNOWLEDGMENTS / REFERENCES -->
<!-- ## References

* []()
* []()
* []() -->


[website]: https://bqwerr.github.io
[linkedin]: https://linkedin.com/in/srujan-tumma
[gmail]: mailto:tummasrujan@gmail.com
[github]: https://github.com/bqwerr
