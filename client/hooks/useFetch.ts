interface hotel{
    id: number,
    nome: string,
    descricao: string,
    dataCriacao: string,
    price: number,
    imgUrl: string
}

let hotels: hotel[] = [
    {
        id: 1,
        nome: "Verde brisa",
        descricao: "hotel famoso não sei oque",
        dataCriacao: "21/01/2005",
        price: 1000.0,
        imgUrl: "https://source.unsplash.com/random/800%C3%97500/?hotel"
    },
    {
        id: 2,
        nome: "Red brisa",
        descricao: "hotel famoso não sei oque",
        dataCriacao: "21/01/2005",
        price: 2000.0,
        imgUrl: "https://source.unsplash.com/random/800%C3%97500/?hotel"
    },
    {
        id: 3,
        nome: "Amarelo brisa",
        descricao: "hotel famoso não sei oque",
        dataCriacao: "21/01/2005",
        price: 3000.0,
        imgUrl: "https://source.unsplash.com/random/800%C3%97500/?hotel"
    },
    {
        id: 4,
        nome: "Azul brisa",
        descricao: "hotel famoso não sei oque",
        dataCriacao: "21/01/2005",
        price: 1000.0,
        imgUrl: "https://source.unsplash.com/random/800%C3%97500/?hotel"
    },
    {
        id: 5,
        nome: "Verde brisa",
        descricao: "hotel famoso não sei oque",
        dataCriacao: "21/01/2005",
        price: 1000.0,
        imgUrl: "https://source.unsplash.com/random/800%C3%97500/?hotel"
    },
    {
        id: 6,
        nome: "Red brisa",
        descricao: "hotel famoso não sei oque",
        dataCriacao: "21/01/2005",
        price: 2000.0,
        imgUrl: "https://source.unsplash.com/random/800%C3%97500/?hotel"
    },
    {
        id: 7,
        nome: "Amarelo brisa",
        descricao: "hotel famoso não sei oque",
        dataCriacao: "21/01/2005",
        price: 3000.0,
        imgUrl: "https://source.unsplash.com/random/800%C3%97500/?hotel"
    },
    {
        id: 8,
        nome: "Azul brisa",
        descricao: "hotel famoso não sei oque",
        dataCriacao: "21/01/2005",
        price: 1000.0,
        imgUrl: "https://source.unsplash.com/random/800%C3%97500/?hotel"
    },
]
export function useFetch(){
    
    function getAllHotels(): hotel[]{
        // TODO fetch all hotels
        return hotels;
    }
    
    function getHotelById(id: number): hotel{
        // TODO fetch hotel by id
        return hotels.find((param) => param.id == id)!
    }
    return {
        getAllHotels,
        getHotelById
    }
}


