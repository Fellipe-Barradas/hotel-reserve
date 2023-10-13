"use client"

import { useFetch } from "@/hooks/useFetch";
import { useParams } from "next/navigation";

interface hotel {
    id: number,
    nome: string,
    descricao: string,
    dataCriacao: string,
    price: number,
    imgUrl: string
}

export default function Hotel() {
    const { getHotelById } = useFetch();
    const param: { id: string } = useParams();
    let id = parseInt(param.id);

    const hotelBuscado: hotel = getHotelById(id);

    return (
        <main className="mt-10 flex flex-col items-center w-[800px] m-auto my-20">
            <img src={hotelBuscado.imgUrl}
                alt="Imagem representando hotel"
                className="w-[800px] h-[500px] bg-no-repeat bg-center rounded-xl shadow-xl" />
            <div className="flex justify-between items-center w-full mt-4">
                <h2 className="text-4xl border-b-2 border-yellow-400">{hotelBuscado.nome}</h2>
                <h2 className="text-2xl border-b-2 border-black">{hotelBuscado.price} R$</h2>
            </div>
            <p className="w-full mt-4 font-light text-md">
                {hotelBuscado.descricao}
            </p>
            <p className="w-full mt-4 font-extralight text-sm">
                {hotelBuscado.dataCriacao}
            </p>


        </main>
    )
}