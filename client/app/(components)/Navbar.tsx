import configFillter from "@/public/config-fillter.svg"
import searchIcon from "@/public/search-icon.svg"
import starIcon from "@/public/uil_favorite.svg"
import profileIcon from "@/public/profile-icon.svg"
import logo from "@/public/logo.png"
import Image from "next/image"


export default function NavBar() {
    return (
        <nav className="flex justify-around align-middle items-center p-2 shadow-md">
            <div className="flex items-center">
            <Image
                        priority
                        src={logo}
                        alt="Fillter button"
                        width={40}
                    />
            <h1 className="text-2xl font-gabarito">Hotel Reserve</h1>
            </div>
            
            <div className="flex justify-between w-1/4 items-center">
                <button>
                    <Image
                        priority
                        src={configFillter}
                        alt="Fillter button"
                        width={20}
                    />
                </button>
                <input
                    type="text"
                    className="rounded-xl p-1 border border-slate-500 shadow-sm
                     hover:shadow-md transition-all focus:outline-0"
                    placeholder="hotel verde brisa..." />
                <button className="border-2 w-7 h-7 flex justify-center items-center
                 rounded-full border-black hover:bg-gray-100 hover:rotate-12 transition-all">
                    <Image
                        priority
                        src={searchIcon}
                        alt="Search button"
                    />
                </button>

            </div>
            <div className="flex gap-5 items-center">
                <Image
                    priority
                    src={starIcon}
                    alt="Favorites button"
                    width={25}
                />
                <Image
                    priority
                    src={profileIcon}
                    alt="Profile button"
                    width={25}
                />
            </div>
        </nav>
    )
}