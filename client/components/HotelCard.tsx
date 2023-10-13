interface HotelProps{
    nome:string,
    dataCriacao: string,
    price: number,
    imgUrl: string
}

export default function HotelCard({nome, dataCriacao, price, imgUrl}:HotelProps){

    return (
        <div className="border-2 w-[320px] border-gray shadow-md rounded-xl 
         flex flex-col hover:shadow-xl transition-shadow 
        cursor-pointer
        ">
            <img src={imgUrl} alt="Imagem" className="w-full h-48 bg-no-repeat bg-center rounded-t-xl"/>
            <h1 className="text-2xl font-gabarito mt-2">{nome}</h1>
            <div className="flex gap-8 justify-between w-full items-center px-2 mt-2 ">
                <p className="text-sm font-light">{dataCriacao}</p>
                <h2>{price} R$</h2>
            </div>
        </div>
    )
}