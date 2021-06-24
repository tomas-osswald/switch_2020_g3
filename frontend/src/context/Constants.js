const prod = {
    url: {
        API_URL: "http://vs116.dei.isep.ipp.pt:8080",
    }
};

const dev = {
    url: {
        API_URL: "http://localhost:8080"
    }
};

export const config = process.env.NODE_ENV === 'development' ? dev : prod;