import configFillter from  "@/public/config-fillter.svg"
import searchIcon from "@/public/search-icon.svg"
import Image from "next/image"


export default function NavBar(){
    return (
        <nav className="flex justify-around align-middle items-center p-2 shadow-md">
            <h1 className="text-2xl">Hotel Reserve</h1>
            <div className="flex justify-between w-1/4 items-center">
                <button>
                    <Image 
                    priority
                    src={configFillter} 
                    alt="Fillter button"
                    width={25}
                    />
                </button>
                <input type="text" className="rounded-xl p-1 border-2 border-slate-500" placeholder="hotel verde brisa..." />
                <button className="border-2 w-7 h-7 flex justify-center items-center
                 rounded-full border-black hover:bg-gray-100 hover:rotate-12 transition-all">
                <Image  
                    priority
                    src={searchIcon} 
                    alt="Fillter button"
                    />
                </button>
            </div>
        </nav>
    )
}