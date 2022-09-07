import Link from "next/link"

export const Navbar: React.FC = () => {
    return (
        <nav className="navbar is-transparent">
            <div className="navbar-brand">
                <a className="navbar-item" href="https://bulma.io">
                    <img src="https://bulma.io/images/bulma-logo.png" alt="Bulma: a modern CSS framework based on Flexbox" width="112" height="28" />
                </a>
            </div>
            <div id="navbarExampleTransparentExample" className="navbar-menu">
                <div className="navbar-start">
                    <div className="navbar-item has-dropdown is-hoverable">
                        <a className="navbar-link" href="#">
                            Cadastrar
                        </a>
                        <div className="navbar-dropdown is-boxed">
                            <Link href="/add/usuario" passHref>
                                <a className="navbar-item">
                                    Usuário
                                </a>
                            </Link>
                            <Link href="/add/unidade" passHref>
                                <a className="navbar-item">
                                    Unidade de Saúde
                                </a>
                            </Link>
                            <Link href="/add/agenda" passHref>
                                <a className="navbar-item">
                                    Agenda
                                </a>
                            </Link>
                        </div>
                    </div>
                    <div className="navbar-item has-dropdown is-hoverable">
                        <a className="navbar-link" href="#">
                            Pesquisar
                        </a>
                        <div className="navbar-dropdown is-boxed">
                            <Link href="/pesquisar/medico" passHref>
                                <a className="navbar-item">
                                    Médicos
                                </a>
                            </Link>
                            <Link href="/pesquisar/paciente" passHref>
                                <a className="navbar-item">
                                    Pacientes
                                </a>
                            </Link>
                            <Link href="/pesquisar/agenda" passHref>
                                <a className="navbar-item">
                                    Agendas
                                </a>
                            </Link>
                            <Link href="/pesquisar/unidade" passHref>
                                <a className="navbar-item">
                                    Unidades
                                </a>
                            </Link>
                        </div>
                    </div>
                    <div className="navbar-item has-dropdown is-hoverable">
                        <a className="navbar-link" href="#">
                            Consultas
                        </a>
                        <div className="navbar-dropdown is-boxed">
                            <Link href="/add/consulta" passHref>
                                <a className="navbar-item">
                                    Marcar
                                </a>
                            </Link>
                            <Link href="/pesquisar/consulta" passHref>
                                <a className="navbar-item">
                                    Listar
                                </a>
                            </Link>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
    )
}

