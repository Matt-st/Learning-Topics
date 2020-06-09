import requests
from asserts import assert_true, assert_equal, assert_raises

def main():
    print("Executing request...")
    print("Retrieveing movies that have walk in the title...")
    payload = {'title': 'walk'}
    r = requests.get('http://localhost:8080/api/movie/search', params=payload)

    assert_equal(861, r.text.count("\"")/2 + 1)
    assert_equal(200, r.status_code)
    print("Integration successful.")




if __name__ == "__main__":
    main()

print("Done")