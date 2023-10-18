import HotelCard from "@/components/HotelCard"
import Link from "next/link"
import Wrapper from "../(components)/Wrapper"

interface hotel{
    id: number,
    nome: string,
    descricao: string,
    dataCriacao: string,
    price: number,
    imgUrl?: string
}

function getFavoriteHotels(): hotel[]{
    // TODO fazer requisição ao servidor

    let favoriteHotels:hotel[] = [
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
    ]
    
    return favoriteHotels
}

export default function Favorite(){

    const favoriteHotels: hotel[] = getFavoriteHotels();
    return (
        <Wrapper>
            <main className="grid grid-cols-1 md:grid-cols-2">
            {favoriteHotels.map((hotel) =>
        <Link href={`/hotel/${hotel.id}`} className="justify-self-center mt-10">
          <HotelCard
            key={hotel.id}
            nome={hotel.nome}
            dataCriacao={hotel.dataCriacao}
            price={hotel.price}
            imgUrl={hotel.imgUrl ? hotel.imgUrl : "url"}
          />
        </Link>
      )}
        </main>
        </Wrapper>
        
    )
}