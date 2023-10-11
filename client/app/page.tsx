import HotelCard from "@/components/HotelCard";

interface hotel{
  nome: string,
  descricao: string,
  dataCriacao: string,
  price: number,
  imgUrl: string
}

function fetchHotels(): hotel[]{

  // TODO : fazer a requisição para o servidor
  let hotels: hotel[] = [
    {
      nome: "Verde brisa",
      descricao: "hotel famoso não sei oque",
      dataCriacao: "21/01/2005",
      price: 1000.0,
      imgUrl: "https://source.unsplash.com/random/500%C3%97300/?hotel"
    },
    {
      nome: "Red brisa",
      descricao: "hotel famoso não sei oque",
      dataCriacao: "21/01/2005",
      price: 2000.0,
      imgUrl: "https://source.unsplash.com/random/500%C3%97300/?hotel"
    },
    {
      nome: "Amarelo brisa",
      descricao: "hotel famoso não sei oque",
      dataCriacao: "21/01/2005",
      price: 3000.0,
      imgUrl: "https://source.unsplash.com/random/500%C3%97300/?hotel"
    },
    {
      nome: "Azul brisa",
      descricao: "hotel famoso não sei oque",
      dataCriacao: "21/01/2005",
      price: 1000.0,
      imgUrl: "https://source.unsplash.com/random/500%C3%97300/?hotel"
    },
    {
      nome: "Verde brisa",
      descricao: "hotel famoso não sei oque",
      dataCriacao: "21/01/2005",
      price: 1000.0,
      imgUrl: "https://source.unsplash.com/random/500%C3%97300/?hotel"
    },
    {
      nome: "Red brisa",
      descricao: "hotel famoso não sei oque",
      dataCriacao: "21/01/2005",
      price: 2000.0,
      imgUrl: "https://source.unsplash.com/random/500%C3%97300/?hotel"
    },
    {
      nome: "Amarelo brisa",
      descricao: "hotel famoso não sei oque",
      dataCriacao: "21/01/2005",
      price: 3000.0,
      imgUrl: "https://source.unsplash.com/random/500%C3%97300/?hotel"
    },
    {
      nome: "Azul brisa",
      descricao: "hotel famoso não sei oque",
      dataCriacao: "21/01/2005",
      price: 1000.0,
      imgUrl: "https://source.unsplash.com/random/500%C3%97300/?hotel"
    },
  ]

  return hotels;
}

export default function Home() {
  
  const hotels:hotel[] = fetchHotels();
  

  return (
    <main className="grid md:grid-cols-2 lg:grid-cols-3 gap-10 mt-8">
      {hotels.map((hotel) => 
      <HotelCard 
        nome={hotel.nome}
        dataCriacao={hotel.dataCriacao}
        price={hotel.price}
        imgUrl={hotel.imgUrl}
      />)}
    </main>
  )
}
