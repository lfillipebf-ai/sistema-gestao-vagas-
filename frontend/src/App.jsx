import {useEffect,useState} from 'react'
const API='http://localhost:8080/api'
function App(){
 const [vagas,setVagas]=useState([]),[filtro,setFiltro]=useState(''),[loading,setLoading]=useState(true)
 async function carregarVagas(){
  setLoading(true)
  try{const r=await fetch(API+'/vagas');if(!r.ok)throw new Error('Não foi possível carregar as vagas.');setVagas(await r.json())}
  catch(e){alert(e.message)}finally{setLoading(false)}
 }
 useEffect(()=>{carregarVagas()},[])
 const filtradas=vagas.filter(v=>`${v.titulo} ${v.empresa} ${v.tecnologia} ${v.modalidade}`.toLowerCase().includes(filtro.toLowerCase()))
 return <main className="container">
  <header><span className="tag">PORTFÓLIO · TI</span><h1>Sistema de Gestão de Vagas</h1><p>Organize vagas, candidatos e candidaturas em um único sistema.</p></header>
  <section className="toolbar"><input value={filtro} onChange={e=>setFiltro(e.target.value)} placeholder="Buscar por empresa, tecnologia ou modalidade..."/><button onClick={carregarVagas}>Atualizar</button></section>
  {loading?<p className="status">Carregando vagas...</p>:filtradas.length===0?<p className="status">Nenhuma vaga encontrada.</p>:<section className="grid">{filtradas.map(v=><article className="card" key={v.id}><div className="card-top"><span>{v.modalidade}</span><strong>{v.tecnologia}</strong></div><h2>{v.titulo}</h2><h3>{v.empresa}</h3><p>{v.localizacao||'Localização não informada'}</p><p>{v.descricao||'Sem descrição disponível.'}</p></article>)}</section>}
  <footer>Desenvolvido por Luis Fillipe Backer Faria · Java + Spring Boot + React + PostgreSQL</footer>
 </main>
}
export default App