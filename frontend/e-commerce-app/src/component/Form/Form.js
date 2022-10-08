import FormItem from "../FormItem/FormItem";

const Form = (props) =>{

  return(
    <div className="">
      <h2>{props.title}</h2>
      <form id="form" onSubmit={props.onSubmit}>
        {
          props.formFields.map((element)=>{
            return (
              <FormItem key={element} field={element} id={element} handleInputChange={props.onChange} />
            )
          })
        }
        <input type="submit" value={props.button} />
      </form>
    </div>
  );
}

export default Form;