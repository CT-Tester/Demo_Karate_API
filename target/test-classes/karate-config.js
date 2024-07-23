function fn(){

    let baseURL;

    baseURL = 'https://petstore.swagger.io/v2';

    karate.configure('ssl', { trustAll: true });

    let config = {
        baseURL
    }

    return config
}
