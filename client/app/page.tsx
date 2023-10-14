import HotelCard from "@/components/HotelCard";
import { useFetch } from "@/hooks/useFetch";
import Link from "next/link";

interface hotel {
  id: number,
  nome: string,
  descricao: string,
  dataCriacao: string,
  price: number,
  imgUrl?: string
}

export default function Home() {

  const { getAllHotels } = useFetch();
  const hotels: hotel[] = getAllHotels();


  return (
    <main className="grid md:grid-cols-2 lg:grid-cols-3 items-center justify-center">
      {hotels.map((hotel) =>
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
  )
}
