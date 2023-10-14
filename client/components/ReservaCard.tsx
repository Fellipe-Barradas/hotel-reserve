interface Props{
    nome: string
    checkIn: string
    checkOut: string 
    cost: number
}

export default function ReservaCard(props: Props){
    const {nome, checkIn, checkOut, cost} = props
    return (
        <div className="flex flex-col shadow-lg gap-1 p-3 border border-gray-700">
            <h1 className="text-xl font-bold">{nome}</h1>
            <div className="font-light">
                <p className="text-sm">{checkIn} - {checkOut}</p>
            </div>
            <h2 className=" mt-4">{cost} R$</h2>
        </div>
    )
}