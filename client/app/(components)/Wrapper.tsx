import { ReactNode } from "react";

interface WrapperProps{
    children:ReactNode
    className?: string
}
export default function Wrapper({children, className}: WrapperProps){
    return (
        <div className={`max-w-[1200px] m-auto ${className}`}>
          {children}
        </div>
      );
}