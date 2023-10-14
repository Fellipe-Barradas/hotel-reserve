import ReservaCard from "@/components/ReservaCard";
import { useFetch } from "@/hooks/useFetch"
import Wrapper from "../(components)/Wrapper";

export default function Profile(){
    const { getUserData } = useFetch();

    const user = getUserData("233131hddgca3");

    return (
        <Wrapper>
            <div className="flex flex-col mt-7">
            <h1 className="text-4xl">Olá <span className="text-blue-600">{user.nome}</span>!</h1>
            <h2 className="text-md font-thin">{user.email}</h2>
            <p className="mt-8 text-2xl">Suas reservas</p>
            <div className="mt-5 grid gap-4">
                {user.reservas.map((reserva) => {
                    return (
                        <ReservaCard 
                            cost={reserva.price}
                            checkIn={reserva.checkIn} 
                            checkOut={reserva.checkOut}
                            nome={reserva.nome}
                            key={reserva.nome}
                        />
                    )
                })}
            </div>
        </div>
        </Wrapper>
        
    )
}