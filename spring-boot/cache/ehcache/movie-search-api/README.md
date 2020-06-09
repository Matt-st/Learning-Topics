# Movie Titles API Challenge

## Description

This is a spring boot application that stands up a endpoint on `http://localhost:8080/api/movie/search` where calls can be made to the json mock endpoint.  This json mock endpoint returns a list of movie information.  The api that I built will search the json mock api to find all movie titles which contain the string that is searched for, sort them, and send the response.

## Features
Searchs for movies by a search string and returns a list of matching movies.

### Cacheing
I have added ehcache to cache the response which improves performance to as low as single digit milliseconds.

## Testing
I have also added testing to the code which has an overall coverage of 73.2%.

## Integration Testing
I created a a small python script which executes a query on the service and asserts the expected values are returned.
Under the integration-tests directory run the following line to execute the integration tests.
`python3 movie-search-integration-tests.py`

