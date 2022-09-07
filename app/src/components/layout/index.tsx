import { ReactNode } from 'react'
import { Navbar } from '../common/navbar'
import { Message } from '../common/message'
import { Alert } from '../common/message'

interface LayoutProps {
    title?: string;
    children?: ReactNode;
    mensagens?: Array<Alert>;
}

export const Layout: React.FC<LayoutProps> = (props: LayoutProps) => {
    return (
        <div className="app">
            <Navbar />
            <section className="main-content columns is-fullheight">
                <div className="container column is-10">
                    <div className="section">
                        <div className="card">
                            <div className="card-header">
                                <p className="card-header-title">
                                    {props.title}
                                </p>
                            </div>
                            <div className="card-content">
                                <div className="content">
                                    {props.mensagens &&
                                        props.mensagens.map(msg => <Message key={msg.texto} {...msg} />)
                                    }
                                    {props.children}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    )
}
