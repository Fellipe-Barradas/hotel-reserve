import configFillter from "@/public/config-fillter.svg"
import searchIcon from "@/public/search-icon.svg"
import starIcon from "@/public/uil_favorite.svg"
import profileIcon from "@/public/profile-icon.svg"
import logo from "@/public/logo.png"
import Image from "next/image"
import Link from "next/link"
import Wrapper from "./Wrapper"

export default function NavBar() {
    return (
        <nav className="shadow-md">
            <Wrapper className="flex justify-between  items-center p-2 ">
            <div className="flex items-center">
            <Link href={"/"}>
            <Image
                        priority
                        src={logo}
                        alt="Fillter button"
                        width={70}
                    />
            
            </Link>
            <h1 className="text-2xl font-gabarito">Hotel Reserve</h1>
            </div>
            
            <div className="flex justify-between items-center gap-3">
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
                <button className="border-2 w-8 h-8 flex justify-center items-center
                 rounded-full border-black hover:bg-gray-100 hover:rotate-12 transition-all">
                    <Image
                        priority
                        src={searchIcon}
                        width={20}
                        alt="Search button"
                    />
                </button>

            </div>
            <div className="flex gap-5 items-center">
                <Link href={"/favorites"}>
                <Image
                    priority
                    src={starIcon}
                    alt="Favorites button"
                    width={25}
                />
                </Link>
                <Link href={"/profile"}>
                <Image
                    priority
                    src={profileIcon}
                    alt="Profile button"
                    width={25}
                />
                </Link>
            </div>
            </Wrapper>
        </nav>
    )
}